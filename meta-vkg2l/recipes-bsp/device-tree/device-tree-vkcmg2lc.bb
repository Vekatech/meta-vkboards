SUMMARY = "Build all custom DTBs for VK-CMG2LC"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PROVIDES += "kernel-devicetree"
RPROVIDES:${PN} += "kernel-devicetree"

SRC_URI = " \
    file://vkcmg2lc/vkcmg2lc.dts \
    file://vkcmg2lc/vkcmg2lc_1.dts \
    ${@' '.join(['file://vkcmg2lc/overlays-vkcmg2lc/%s' % f for f in [ \
        'vkrz-cm33.dts', 'vkrz-cm-scif2.dts', 'vkrz-cm-usb1.dts', \
        'vkrz-csi-ov5645.dts', 'vkrz-dsi-kd070hdfia030.dts', \
        'vkrz-dsi-kd101wxfid045.dts', 'vkrz-qspi-mx25l51245g.dts', \
        'vkrz-udma.dts' \
    ]])} \
"

S = "${WORKDIR}"
DTB_OUTPUT_DIR = "${S}/dtbs"
OVERLAY_OUTPUT_DIR = "${S}/dtbo"

inherit deploy

DEPENDS += "dtc-native virtual/kernel"

do_compile[depends] += "virtual/kernel:do_configure"

do_compile() {
    DTS_BASE="${STAGING_KERNEL_DIR}/arch/arm64/boot/dts"
	mkdir -p ${DTB_OUTPUT_DIR} ${OVERLAY_OUTPUT_DIR}
	mkdir -p ${DTB_OUTPUT_DIR}

	# Compile standard DTBs
    for dts in $(find ${S}/vkcmg2lc -name '*.dts' | grep -v overlays); do
        name=$(basename ${dts} .dts)
        # Preprocess with cpp
        cpp -nostdinc -undef -x assembler-with-cpp \
            -I ${DTS_BASE} \
            -I ${DTS_BASE}/renesas \
            -I ${STAGING_KERNEL_DIR}/include \
            -I ${S}/vkcmg2lc \
            ${dts} > ${DTB_OUTPUT_DIR}/${name}.dts.preprocessed

        dtc -@ -I dts -O dtb \
            -i ${DTS_BASE} \
            -i ${DTS_BASE}/renesas \
            -i ${STAGING_KERNEL_DIR}/include \
            -i ${S}/vkcmg2lc \
            -o ${DTB_OUTPUT_DIR}/${name}.dtb \
            ${DTB_OUTPUT_DIR}/${name}.dts.preprocessed
    done

    # Compile overlays (DTBO)
    for overlay in $(find ${S}/vkcmg2lc/overlays-vkcmg2lc -name '*.dts'); do
        name=$(basename ${overlay} .dts)

        cpp -nostdinc -undef -x assembler-with-cpp \
            -I ${DTS_BASE} \
            -I ${DTS_BASE}/renesas \
            -I ${STAGING_KERNEL_DIR}/include \
            -I ${S}/vkcmg2lc/overlays-vkcmg2lc \
            ${overlay} > ${OVERLAY_OUTPUT_DIR}/${name}.dts.preprocessed

        dtc -@ -I dts -O dtb \
            -o ${OVERLAY_OUTPUT_DIR}/${name}.dtbo \
            ${OVERLAY_OUTPUT_DIR}/${name}.dts.preprocessed
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

