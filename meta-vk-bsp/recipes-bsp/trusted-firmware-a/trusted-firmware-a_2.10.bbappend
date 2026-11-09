DESCRIPTION = "Trusted Firmware-A for VK-boards"

TFA_REV ?= "f59ed5a31ef6b28200e9ba35fc78a607fdeda6dd"
TFA_BRANCH ?= "v2.10/rzg2"

EXTRA_OEMAKE:append ?= " SPI_FLASH=${TFA_SPI_FLASH}"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = "\
	file://0001-add-vkboards-support.patch \
"

