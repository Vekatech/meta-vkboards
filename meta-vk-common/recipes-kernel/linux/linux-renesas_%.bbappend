COMPATIBLE_MACHINE_vkrzv2l = "vkrzv2l"
COMPATIBLE_MACHINE_vkrzg2l = "vkrzg2l"
COMPATIBLE_MACHINE_vkrzg2lc = "vkrzg2lc"
COMPATIBLE_MACHINE_vkcmg2lc = "vkcmg2lc"
COMPATIBLE_MACHINE_vk-d184280e = "vk-d184280e"
COMPATIBLE_MACHINE_vkrzg2ul = "vkrzg2ul"

SRCREV = "7b2ceeb26afb39089e42d55c958f9c0212c07ac1"
SRCREV_vkrzg2lc = "e2055fbbd7d71b6b3f4793f615aff62ed16c5e77"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0003-update-some-Macronix-device-names-against-jedec-ID.patch \
	file://0004-disable-energy-efficiency-for-RTL8211F-leds.patch \
	file://0005-add-support-for-Fitipower-EK79007AD-and-EK79202D-bas.patch \
"

SRC_URI_append_vk-d184280e = " \
	file://0001-RS-485-Half-Duplex-Communication-with-GPIO-pin-contr.patch \
	file://0011-add-support-for-vk-d184280e-board-ant-its-overlays.patch \
	file://0017-DMA-disabling-for-rzg2l-scif3.patch \
"

SRC_URI_append_vkrzg2ul = " \
	file://0001-RS-485-Half-Duplex-Communication-with-GPIO-pin-contr.patch \
	file://0013-add-support-for-vkrzg2ul-and-its-overlays.patch \
	file://0021-DMA-disabling-for-rzg2ul-scif1-scif2.patch \
	file://0022-add-overlays-for-vkrzg2ul-board.patch \
"

SRC_URI_append_vkrzg2l = " \
	file://0014-add-support-for-Lontium-LT8912B-DSI-HDMI-bridge.patch \
	file://0015-add-support-for-vkrzg2l-board-and-its-overlays.patch \
	file://0018-add-udmabuf-overlay-for-vkrzg2l-board.patch \
	file://0023-add-support-for-enable-gpio-on-fitipower-ek79202d.patch \
	file://0024-add-overlay-with-lcd-power-control-for-vkrzg2l.patch \
"

SRC_URI_append_vkrzv2l = " \
	file://0014-add-support-for-Lontium-LT8912B-DSI-HDMI-bridge.patch \
	file://0016-add-support-for-vkrzv2l-board-and-its-overlays.patch \
	file://0019-vkrzv2l-adjust-isp_buf0-and-isp_work0-memory-regions.patch \
"

SRC_URI_append_vkrzv2l = " ${@oe.utils.conditional("CONFIG_OPENCVA", "1", " file://0020-modified-devicetree-for-opencva-drv-vkrzv2l.patch ", "", d)} "

KBUILD_DEFCONFIG = "defconfig"
KCONFIG_MODE = "alldefconfig"

FILESEXTRAPATHS_prepend := "${THISDIR}/Kconfigs:"

SRC_URI += " \
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
	file://overlays.cfg \
	"

SRC_URI += " ${@oe.utils.conditional("CONFIG_HASSI", "1", " file://docker.cfg file://apparmor.cfg ", "", d)} "

SRC_URI_append_vkrzg2l = " \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://PANEL_ILITEK_ILI9881C.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
	file://LONTIUM_LT8912B.cfg \
	file://SND_SOC_DA7213.cfg \
	file://SND_SEQ.cfg \
	file://BOARD_VKRZG2L.cfg \
	"

SRC_URI_append_vkrzv2l = " \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://PANEL_ILITEK_ILI9881C.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
	file://LONTIUM_LT8912B.cfg \
	file://SND_SOC_DA7213.cfg \
	file://SND_SEQ.cfg \
	file://BOARD_VKRZV2L.cfg \
	"

SRC_URI_append_vkrzg2lc = " \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://PANEL_ILITEK_ILI9881C.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
	file://SND_SOC_DA7213.cfg \
	file://SND_SEQ.cfg \
	file://CIFS.cfg \
	file://BOARD_VKRZG2LC.cfg \
	"

SRC_URI_append_vkcmg2lc = " \
	file://GT911.cfg \
	file://FT5X06.cfg \
	file://PANEL_PANEL_FITIPOWER_EK79202D.cfg \
	file://SND_SOC_MAX9867.cfg \
	file://SND_SEQ.cfg \
	file://BOARD_VKCMG2LC.cfg \
	"

SRC_URI_append_vk-d184280e = " \
	file://BOARD_VK_D184280E.cfg \
	"

SRC_URI_append_vkrzg2ul = " \
	file://BOARD_VKRZG2UL.cfg \
	file://SND_SOC_DA7213.cfg \
	file://SND_SEQ.cfg \
	file://CIFS.cfg \
	"

KERNEL_DEVICETREE = ""
