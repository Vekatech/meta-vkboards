SUMMARY = "U-Boot Env"
SECTION = "app"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

COMPATIBLE_MACHINE_vkrzv2l = "vkrzv2l"
COMPATIBLE_MACHINE_vkrzg2l = "vkrzg2l"
COMPATIBLE_MACHINE_vkrzg2lc = "vkrzg2lc"
COMPATIBLE_MACHINE_vkcmg2lc = "vkcmg2lc"
COMPATIBLE_MACHINE_vkrzg2ul = "vkrzg2ul"
COMPATIBLE_MACHINE_vk-d184280e = "vk-d184280e"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

S = "${WORKDIR}"

SRC_URI = " \
    file://readme.txt \
"

SRC_URI_append_vkrzg2l = " \
    file://uEnv-vkrzg2l.txt \
    "
SRC_URI_append_vkrzv2l = " \
    file://uEnv-vkrzv2l.txt \
    "

SRC_URI_append_vkrzv2l =  " ${@oe.utils.conditional("CONFIG_OPENCVA", "1", " file://OpenCV_Bin_v1.10.bin ", "", d)} "


SRC_URI_append_vkrzg2lc = " \
    file://uEnv-vkrzg2lc.txt \
    "
SRC_URI_append_vkcmg2lc = " \
    file://uEnv-vkcmg2lc.txt \
    "
SRC_URI_append_vk-d184280e = " \
    file://uEnv-vk-d184280e.txt \
    "

SRC_URI_append_vkrzg2ul = " \
    file://uEnv-vkrzg2ul.txt \
    "

FILES_${PN} = "/boot"

do_install () {
    install -d ${D}/boot
    install -m 0644 ${S}/uEnv-"${MACHINE}".txt ${D}/boot/uEnv.txt
    install -m 0644 ${S}/readme.txt ${D}/boot/readme.txt
}

DO_OPENCVA_APPEND =  "${@'1' if d.getVar('CONFIG_OPENCVA') == "1" else '0'}"

do_install_append_vkrzv2l () {
    if [ "${DO_OPENCVA_APPEND}" == "1" ] ; then
        install -m 0644 ${S}/OpenCV_Bin_v*.bin ${D}/boot/OpenCV_Bin.bin
    fi
}

inherit deploy
addtask deploy after do_install

do_deploy () {
    install -m 0644 ${D}/boot/uEnv.txt ${DEPLOYDIR}
    install -m 0644 ${D}/boot/readme.txt ${DEPLOYDIR}
}

do_deploy_append_vkrzv2l () {
    if [ "${DO_OPENCVA_APPEND}" == "1" ] ; then
	install -m 0644 ${D}/boot/OpenCV_Bin.bin ${DEPLOYDIR}
    fi
} 

PACKAGE_ARCH = "${MACHINE_ARCH}"
