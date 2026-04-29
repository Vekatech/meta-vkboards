SECTION = "bootloaders"
DESCRIPTION = "Application to create binaries in the correct format for rzg2l board flashing"
SUMMARY = "Bptool from Trusted Firmware-A"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit native

S = "${WORKDIR}"

FILESEXTRAPATHS:prepend := "${THISDIR}/rz_boot_param:"

SRC_URI = "file://bptool.c"

do_compile () {
         ${CC} bptool.c -o bptool
}

do_install () {
    install -d ${D}${bindir}
    install ${WORKDIR}/bptool ${D}${bindir}
}

