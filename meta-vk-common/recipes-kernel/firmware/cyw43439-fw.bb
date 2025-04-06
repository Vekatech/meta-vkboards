SUMMARY = "Firmware for CYW43439 Wi-Fi module"
DESCRIPTION = "Installs only the required firmware files for CYW43439"
LICENSE = "BSD-3-Clause"

LIC_FILES_CHKSUM = " \
	file://${S}/cyw-bt-patch/LICENCE.cypress;md5=cbc5f665d04f741f1e006d2096236ba7 \
	file://${S}/cyw-fmac-fw/LICENCE;md5=cbc5f665d04f741f1e006d2096236ba7 \
	file://${S}/cyw-fmac-nvram/LICENCE.cypress;md5=cbc5f665d04f741f1e006d2096236ba7 \
	file://${S}/ifx-linux-firmware/LICENCE;md5=cbc5f665d04f741f1e006d2096236ba7 \
	"

SRC_URI = " \
    git://github.com/murata-wireless/cyw-fmac-fw;protocol=https;branch=indrik;destsuffix=cyw-fmac-fw;name=cyw-fmac-fw \
    git://github.com/murata-wireless/cyw-fmac-nvram;protocol=https;branch=indrik;destsuffix=cyw-fmac-nvram;name=cyw-fmac-nvram \
    git://github.com/murata-wireless/cyw-bt-patch;protocol=https;branch=kirkstone-indrik;destsuffix=cyw-bt-patch;name=cyw-bt-patch \
	git://github.com/bonev-st/ifx-linux-firmware;branch=v5.15;destsuffix=ifx-linux-firmware;name=ifx-linux-firmware \
"

SRCREV_cyw-fmac-fw="544afc1e7c6973a38e7b1ffc6bacb3760c61880d"
SRCREV_cyw-fmac-nvram="0ddeb1a3b24cb8f681c0c58f658d0de8c82b4c8c"
SRCREV_cyw-bt-patch="ad078a3ed656e48e686c9b9ef7023e3c5c25f11f"
SRCREV_ifx-linux-firmware="1f566522104f69adab2639d798616db1fa795d66"

inherit allarch

COMPATIBLE_STRING = "vekatech,${MACHINE}"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/lib/firmware/cypress
    install -d ${D}/lib/firmware/brcm

	install -m 444 ${S}/cyw-fmac-fw/cyfmac43439-sdio.1YN.clm_blob  ${D}/lib/firmware/cypress/cyfmac43439-sdio.clm_blob
	install -m 444 ${S}/cyw-fmac-nvram/cyfmac43439-sdio.1YN.txt ${D}/lib/firmware/cypress/cyfmac43439-sdio.txt
	install -m 444 ${S}/ifx-linux-firmware/firmware/cyfmac43439-sdio.bin ${D}/lib/firmware/cypress/cyfmac43439-sdio.bin
    install -m 444 ${S}/cyw-bt-patch/CYW4343A2_001.003.016.0031.0000.1YN.hcd ${D}/lib/firmware/brcm/CYW4343A2.hcd


	ln -sf cyfmac43439-sdio.bin ${D}/lib/firmware/cypress/cyfmac43439-sdio.${COMPATIBLE_STRING}.bin
	ln -sf cyfmac43439-sdio.txt ${D}/lib/firmware/cypress/cyfmac43439-sdio.${COMPATIBLE_STRING}.txt

	ln -sf CYW4343A2.hcd ${D}/lib/firmware/brcm/BCM.hcd
}

FILES:${PN} += "${nonarch_base_libdir}/firmware/cypress ${nonarch_base_libdir}/firmware/brcm"

RPROVIDES:${PN} += "linux-firmware-brcmfmac43439-sdio"
RREPLACES:${PN} += "${RPROVIDES:${PN}}"
RCONFLICTS:${PN} += "${RPROVIDES:${PN}}"
