LIC_FILES_CHKSUM = " \
	file://${WORKDIR}/git/docs/license.rst;md5=b2c740efedc159745b9b31f88ff03dde \
"

require fiptool-native.inc

TFA_URI ?= "git://github.com/renesas-rz/rzg_trusted-firmware-a.git;protocol=https"
TFA_REV ?= "f59ed5a31ef6b28200e9ba35fc78a607fdeda6dd"

SRC_URI = "${TFA_URI};nobranch=1"
SRCREV = "${TFA_REV}"

PV = "2.10+git"