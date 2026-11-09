SUMMARY = "Firmware for CYW43439 Wi-Fi module"
DESCRIPTION = "Installs only the required firmware files for CYW43439"
VERSION = "1.0.0"

LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"
FW_OUTPUT_DIR = "${nonarch_base_libdir}/firmware"
CYP_FW_DIR = "${FW_OUTPUT_DIR}/cypress"
BCM_FW_DIR = "${FW_OUTPUT_DIR}/brcm"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
	file://cyfmac43439-sdio.1YN.clm_blob \
	file://cyfmac43439-sdio.clm_blob \
	file://cyfmac43439-sdio.1YN.txt \
	file://cyfmac43439-sdio.bin \
	file://CYW4343A2_001.003.016.0071.0017.1YN.hcd \
	"

inherit allarch

COMPATIBLE_STRING = "vekatech,${MACHINE}"

do_install() {
    install -d ${D}${CYP_FW_DIR}
    install -d ${D}${BCM_FW_DIR}

    install -m 0644 ${S}/cyfmac43439-sdio.1YN.clm_blob  ${D}${CYP_FW_DIR}/cyfmac43439-sdio.clm_blob
    install -m 0644 ${S}/cyfmac43439-sdio.1YN.txt ${D}${CYP_FW_DIR}/cyfmac43439-sdio.txt
    install -m 0644 ${S}/cyfmac43439-sdio.bin ${D}${CYP_FW_DIR}/cyfmac43439-sdio.bin
    install -m 0644 ${S}/CYW4343A2_001.003.016.0071.0017.1YN.hcd ${D}${BCM_FW_DIR}/CYW4343A2.hcd

    ln -sf cyfmac43439-sdio.bin ${D}${CYP_FW_DIR}/cyfmac43439-sdio.${COMPATIBLE_STRING}.bin
    ln -sf cyfmac43439-sdio.txt ${D}${CYP_FW_DIR}/cyfmac43439-sdio.${COMPATIBLE_STRING}.txt

    ln -sf CYW4343A2.hcd ${D}${BCM_FW_DIR}/BCM.hcd
}

FILES:${PN} += "${CYP_FW_DIR} ${BCM_FW_DIR}"

RPROVIDES:${PN} += "linux-firmware-brcmfmac43439-sdio"
RREPLACES:${PN} += "${RPROVIDES:${PN}}"
RCONFLICTS:${PN} += "${RPROVIDES:${PN}}"
