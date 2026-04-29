COMPATIBLE_MACHINE:vkrzg2lc = "vkrzg2lc"
COMPATIBLE_MACHINE:vk-d184280e = "vk-d184280e"

SRCREV = "9e113d74d2ab12af3e8aec11977e570d1fa8610a"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
	file://0002-update-some-Macronix-device-names-against-jedec-ID.patch \
	file://0003-disable-energy-efficiency-for-RTL8211F-leds.patch \
	file://0004-add-support-for-Fitipower-EK79xxxD-based-lcd-panels.patch \
	file://0016-add-support-for-KD070HDFIA030-LCD-panel.patch \
"

SRC_URI:append:vk-d184280e = " \
	file://0015-add-support-for-Infineon-CYW43439-1YN-module.patch \
"

KBUILD_DEFCONFIG = "defconfig"
KCONFIG_MODE = "alldefconfig"

FILESEXTRAPATHS:prepend := "${THISDIR}/Kconfigs:"

SRC_URI:append = " \
	file://ADV7511.cfg \
	file://CANBUS.cfg \
	file://EEPROM_I2C.cfg \
	file://MXTTOUCH.cfg \
	file://NETWORK.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79007AD.cfg \
	file://RTL8211F.cfg \
	file://TRACEPOINTS.cfg \
	file://USB_GADGET.cfg \
	file://USB_ACM.cfg \
	file://USB_SERIAL.cfg \
	file://USB_MODEM.cfg \
	file://USB_WL.cfg \
	file://BT.cfg \
	"

SRC_URI += " ${@oe.utils.conditional("CONFIG_HASSI", "1", " file://docker.cfg file://apparmor.cfg ", "", d)} "

SRC_URI:append:vkrzg2lc = " \
	file://BOARD_VKRZG2LC.cfg \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://PANEL_ILITEK_ILI9881C.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
	file://SND_SOC_DA7213.cfg \
	file://SND_SEQ.cfg \
	file://CIFS.cfg \
	" 

SRC_URI:append:vk-d184280e = " \
	file://BOARD_VK_D184280E.cfg \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://CYW43439.cfg \
"
