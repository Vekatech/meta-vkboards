DESCRIPTION = "Trusted Firmware-A for VK-boards"
COMPATIBLE_MACHINE:vkrzg2lc = "vkrzg2lc"
COMPATIBLE_MACHINE:vk-d184280e = "vk-d184280e"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
	file://0001-add-vkboards-support.patch \
"

B = "${S}/build"

FILES:${PN} = "/firmware "
SYSROOT_DIRS += "/firmware"

BUILD_DIR = "${B}/${TFA_PLATFORM}"
#BUILD_DIR .= "${@'/${TFA_BOARD}' if d.getVar('TFA_BOARD') else ''}"
BUILD_DIR .= "/${@'debug' if d.getVar("TFA_DEBUG") == '1' else 'release'}"

# What to install
# do_install and do_deploy will install everything listed in this
# variable. It is set by default to TFA_BUILD_TARGET
TFA_INSTALL_TARGET ?= "${TFA_BUILD_TARGET}"

EXTRA_OEMAKE:append ?= " SPI_FLASH=${TFA_SPI_FLASH}"

do_compile() {
    # Currently there are races if you build all the targets at once in parallel
    for T in ${TFA_BUILD_TARGET}; do
        oe_runmake PLAT=${TFA_PLATFORM} BOARD=${TFA_BOARD} ${EXTRA_FLAGS} ${EXTRA_OEMAKE} -C ${S} $T
    done
}

do_install() {

    install -d -m 755 ${D}/firmware

    for atfbin in ${TFA_INSTALL_TARGET}; do
        if [ -f ${BUILD_DIR}/$atfbin.bin ]; then
            echo "Install $atfbin.bin"
            install -m 0644 ${BUILD_DIR}/$atfbin.bin ${D}/firmware/$atfbin-${TFA_PLATFORM}.bin
            ln -sf $atfbin-${TFA_PLATFORM}.bin ${D}/firmware/$atfbin.bin
	fi
    done
}

do_deploy() {
    cp -r ${D}/firmware/* ${DEPLOYDIR}/
}
