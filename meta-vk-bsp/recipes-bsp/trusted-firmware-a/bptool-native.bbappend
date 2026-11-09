FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
	file://0001-modify-bptool-mode-names.patch \
"


TFA_URI ?= "git://github.com/renesas-rz/rzg_trusted-firmware-a.git;protocol=https"
TFA_REV ?= "f59ed5a31ef6b28200e9ba35fc78a607fdeda6dd"

SRC_URI = "${TFA_URI};nobranch=1"
SRCREV = "${TFA_REV}"

PV = "v2.10+git"
