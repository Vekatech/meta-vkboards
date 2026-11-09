FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"


SRCREV = "6717c06c72df7430323d0d48258ae4090f2d76aa"

SRC_URI:append = " \
	file://0001-update-some-Macronix-device-names-against-jedec-ID.patch \
	file://0002-dts-renesas-r9a07g044-fix-dtc-warning.patch \
	file://0003-drm-ti-sn65dsi83-disable-PLL-error.patch \
	file://0005-add-vk-lcd-panels-support.patch \
	file://0006-phy-RTL8211F-eee-broken-support.patch \
"

SRC_URI:append = " ${@oe.utils.conditional("CONFIG_WLAN_CYW43439", "1", " file://0004-add-support-for-Infineon-wireless-solutions.patch ", "", d)} "

KBUILD_DEFCONFIG = "defconfig"
KCONFIG_MODE = "alldefconfig"


FILESEXTRAPATHS:prepend := "${THISDIR}/Kconfigs:"

SRC_URI += " \
	file://ADV7511.cfg \
	file://CANBUS.cfg \
	file://EEPROM_I2C.cfg \
	file://NETWORK.cfg \
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

SRC_URI:append = " ${@oe.utils.conditional("CONFIG_WLAN_CYW43439", "1", " file://CYW43439.cfg ", "", d)} "

SRC_URI:append = " ${@oe.utils.conditional("CONFIG_GPIO_MCP23x17", "1", " file://MCP23S08_GPIO.cfg ", "", d)} "

SRC_URI:append = " ${@oe.utils.conditional("CONFIG_DSI_BRIDGES", "1", " file://DSI_BRIDGES.cfg ", "", d)} "


SRC_URI:append:vkrzg2lc = " \
	file://BOARD_VKRZG2LC.cfg \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://MXTTOUCH.cfg \
	file://PANEL_ILITEK_ILI9881C.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79007AD.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
	file://SND_SOC_DA7213.cfg \
	file://SND_SEQ.cfg \
	file://CIFS.cfg \
	file://DSI_BRIDGES.cfg \
	file://USB_TOUCH.cfg \
"

SRC_URI:append:vk-d184280e = " \
	file://BOARD_VK_D184280E.cfg \
	file://MXTTOUCH.cfg \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79007AD.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
"

SRC_URI:append:vk-d184280e_1 = " \
	file://BOARD_VK_D184280E.cfg \
	file://MXTTOUCH.cfg \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79007AD.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
"

SRC_URI:append:vkcmg2l = " \
	file://BOARD_VKCMG2L.cfg \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://MXTTOUCH.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79007AD.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
	file://SND_SOC_MAX9867.cfg \
	file://SND_SEQ.cfg \
	file://CIFS.cfg \
	file://DSI_BRIDGES.cfg \
	file://USB_TOUCH.cfg \
"

SRC_URI:append:vkcmg2lc-vm = " \
	file://BOARD_VKCMG2LC-VM.cfg \
	file://SND_SOC_MAX9867.cfg \
	file://SND_SEQ.cfg \
	file://CIFS.cfg \
	file://DSI_BRIDGES.cfg \
	file://USB_TOUCH.cfg \
"

SRC_URI:append:vkcmg2lc-vm-bare = " \
	file://BOARD_VKCMG2LC-VM.cfg \
	file://SND_SOC_MAX9867.cfg \
	file://SND_SEQ.cfg \
	file://CIFS.cfg \
"

SRC_URI:append:vkrzg2ul = " \
	file://BOARD_VKRZG2UL.cfg \
	file://SND_SOC_DA7213.cfg \
	file://SND_SEQ.cfg \
	file://CIFS.cfg \
"


