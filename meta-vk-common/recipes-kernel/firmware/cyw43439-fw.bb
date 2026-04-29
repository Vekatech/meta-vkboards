SUMMARY = "Firmware for CYW43439 Wi-Fi module"
DESCRIPTION = "Installs only the required firmware files for CYW43439"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

S = "${WORKDIR}"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
	file://cyfmac43439-sdio.1YN.clm_blob \
	file://cyfmac43439-sdio.clm_blob \
	file://cyfmac43439-sdio.1YN.txt \
	file://cyfmac43439-sdio.bin \
	file://CYW4343A2_001.003.016.0031.0000.1YN.hcd \
	"

inherit allarch

COMPATIBLE_STRING = "vekatech,${MACHINE}"

do_install() {
    install -d ${D}/lib/firmware/cypress
    install -d ${D}/lib/firmware/brcm

    install -m 444 ${S}/cyfmac43439-sdio.1YN.clm_blob  ${D}/lib/firmware/cypress/cyfmac43439-sdio.clm_blob
    install -m 444 ${S}/cyfmac43439-sdio.1YN.txt ${D}/lib/firmware/cypress/cyfmac43439-sdio.txt
    install -m 444 ${S}/cyfmac43439-sdio.bin ${D}/lib/firmware/cypress/cyfmac43439-sdio.bin
    install -m 444 ${S}/CYW4343A2_001.003.016.0031.0000.1YN.hcd ${D}/lib/firmware/brcm/CYW4343A2.hcd

    ln -sf cyfmac43439-sdio.bin ${D}/lib/firmware/cypress/cyfmac43439-sdio.${COMPATIBLE_STRING}.bin
    ln -sf cyfmac43439-sdio.txt ${D}/lib/firmware/cypress/cyfmac43439-sdio.${COMPATIBLE_STRING}.txt

    ln -sf CYW4343A2.hcd ${D}/lib/firmware/brcm/BCM.hcd
}

FILES:${PN} += "${nonarch_base_libdir}/firmware/cypress ${nonarch_base_libdir}/firmware/brcm"

RPROVIDES:${PN} += "linux-firmware-brcmfmac43439-sdio"
RREPLACES:${PN} += "${RPROVIDES:${PN}}"
RCONFLICTS:${PN} += "${RPROVIDES:${PN}}"
