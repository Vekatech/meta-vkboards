# Released under the MIT license (see COPYING.MIT for the terms)
DESCRIPTION = "Cypress Orga Wi-Fi driver backport recipe"
HOMEPAGE = "https://github.com/murata-wireless"
SECTION = "kernel/modules"
LICENSE = "GPL-2.0-only"


LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

SRC_URI =  " \
    git://github.com/murata-wireless/cyw-fmac;protocol=http;branch=imx-kirkstone-indrik \
    file://0001-Update-Makefile-to-skip-depmod-for-Yocto.patch;apply=yes \
"

SRCREV = "4c5275d220ef9cc28b341bd1f9da5b02c76a5b89"

S = "${WORKDIR}/git"

# EXTRA_OEMAKE = "KLIB_BUILD=${STAGING_KERNEL_DIR} KLIB=${D} DESTDIR=${D}"
EXTRA_OEMAKE = " \
    KLIB_BUILD=${STAGING_KERNEL_DIR} \
    KLIB=${D}/lib/modules/${KERNEL_VERSION} \
    INSTALL_MOD_PATH=${D} \
    DEPMOD=true \
"

DEPENDS += "virtual/kernel bison-native flex-native"
inherit module-base

do_configure:prepend() {
	chmod -R 777 ./
	cp ${STAGING_KERNEL_BUILDDIR}/.config ${STAGING_KERNEL_DIR}/.config
	LEX=flex YACC=yacc CC=${BUILD_CC} oe_runmake defconfig-brcmfmac
}

do_configure:append() {
	oe_runmake
}

FILES:${PN} += "${nonarch_base_libdir}/udev \
                ${sysconfdir}/udev \
				${nonarch_base_libdir} \
               "

do_configure() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake clean
}

do_compile() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake
}

do_install() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
    oe_runmake modules_install
}
