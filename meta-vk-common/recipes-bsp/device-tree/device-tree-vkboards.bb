SUMMARY = "Build DTBs and overways for VK boards"
DESCRIPTION = "Build DTBs and overlays for VK boards"
VERSION = "1.0.0"

LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

require include/device-tree.inc

PROVIDES += "kernel-devicetree"
RPROVIDES:${PN} += "kernel-devicetree"

S = "${WORKDIR}"
DTB_OUTPUT_DIR = "${S}/dtbs"
OVERLAY_OUTPUT_DIR = "${S}/dtbo"

inherit deploy

DEPENDS += "dtc-native virtual/kernel"

do_compile[depends] += "virtual/kernel:do_configure"

do_compile() {
    DTS_BASE="${STAGING_KERNEL_DIR}/arch/arm64/boot/dts"
    mkdir -p ${DTB_OUTPUT_DIR} ${OVERLAY_OUTPUT_DIR}

    # Function to preprocess and compile a DTS file
    preprocess_and_compile_dts() {
        local input_file=$1
        local output_file=$2

        # Preprocess the DTS file with cpp
        local preprocessed_file="${output_file}.tmp"
        cpp -nostdinc -undef -D__DTS__ -x assembler-with-cpp \
            -I ${DTS_BASE} \
            -I ${DTS_BASE}/renesas \
            -I ${STAGING_KERNEL_DIR}/include \
            -I ${S}/${MACHINE} \
            ${input_file} > ${preprocessed_file}

		dtc -@ -I dts -O dtb -b 0 \
			-Wnode_name_chars_strict \
			-Wproperty_name_chars_strict \
			-o ${output_file} \
			${preprocessed_file}

		#rm -f ${preprocessed_file}
    }

    # Compile standard DTBs (without -@)
    find ${S}/${MACHINE} -name '*.dts' | grep -v overlays | while read -r dts; do
        name=$(basename ${dts} .dts)
        preprocess_and_compile_dts "${dts}" "${DTB_OUTPUT_DIR}/${name}.dtb"
	done

    # Compile overlays (DTBOs, with -@)
    find ${S}/${MACHINE}/overlays-${MACHINE} -name '*.dts' | while read -r overlay; do
		name=$(basename ${overlay} .dts)
        preprocess_and_compile_dts "${overlay}" "${OVERLAY_OUTPUT_DIR}/${name}.dtbo"
	done
}

do_install() {
    install -d ${D}/boot
    install -m 0644 ${DTB_OUTPUT_DIR}/*.dtb ${D}/boot/

    install -d ${D}/boot/overlays
    install -m 0644 ${OVERLAY_OUTPUT_DIR}/*.dtbo ${D}/boot/overlays/
}

do_deploy() {
    install -d ${DEPLOYDIR}
	install -d ${DEPLOYDIR}/overlays

    if ls ${DTB_OUTPUT_DIR}/*.dtb 1>/dev/null 2>&1; then
        install -m 0644 ${DTB_OUTPUT_DIR}/*.dtb ${DEPLOYDIR}/
    fi

    if ls ${OVERLAY_OUTPUT_DIR}/*.dtbo 1>/dev/null 2>&1; then
        install -m 0644 ${OVERLAY_OUTPUT_DIR}/*.dtbo ${DEPLOYDIR}/overlays/
    fi
}

addtask deploy after do_install

FILES:${PN} = "/boot/*.dtb /boot/overlays/*.dtbo"

