FILESEXTRAPATHS:prepend := "${THISDIR}/u-boot:"

UBOOT_REV ?= "4eebfbaa4e61f8d3fa0e44ae59449213ffee981c"


SRC_URI:append = " ${@oe.utils.conditional("CONFIG_UBOOT_CM33CMD", "1", " file://0001-add-support-for-cm33-command.patch ", "", d)} "

SRC_URI:append = " \
	file://0002-disable-EEE-for-ethernet-phy-LEDs.patch \
	file://0003-adjust-INFO-for-used-Macronix-flash-devices.patch \
	file://0004-add-option-rawimg-for-fastboot-flash-write-command.patch \
	file://0005-fastboot-add-CONFIG_USB_EPMAXPACK_FASTBOOT-option-wh.patch \
	file://0006-add-support-for-WDTOVF_PERROUT-signal.patch \
	file://0008-add-vk-boards-common-files.patch \
	file://0009-add-Vekatech-boards-support.patch \
	file://0010-add-support-for-VM-Carrier.patch \
"        


#SRC_URI:append = " file://0007-prevent-LMB-file-reading-check-address.patch " 
