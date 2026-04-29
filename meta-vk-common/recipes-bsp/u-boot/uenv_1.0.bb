SUMMARY = "U-Boot Env"
SECTION = "app"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

COMPATIBLE_MACHINE:vkrzg2lc = "vkrzg2lc"
COMPATIBLE_MACHINE:vk-d184280e = "vk-d184280e"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

S = "${WORKDIR}"

SRC_URI = " \
    file://readme.txt \
    file://${UENV_FILE} \
"

FILES:${PN} = "/boot"

do_install () {
    install -d ${D}/boot
    install -m 0644 ${S}/${UENV_FILE} ${D}/boot/uEnv.txt
    install -m 0644 ${S}/readme.txt ${D}/boot/readme.txt
}

inherit deploy
addtask deploy after do_install

do_deploy () {
    install -m 0644 ${D}/boot/uEnv.txt ${DEPLOYDIR}
    install -m 0644 ${D}/boot/readme.txt ${DEPLOYDIR}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

