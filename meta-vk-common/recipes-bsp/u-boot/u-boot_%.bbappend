COMPATIBLE_MACHINE_vkrzg2l = "vkrzg2l"
COMPATIBLE_MACHINE_vkrzv2l = "vkrzv2l"
COMPATIBLE_MACHINE_vkrzg2lc = "vkrzg2lc"
COMPATIBLE_MACHINE_vkcmg2lc = "vkcmg2lc"
COMPATIBLE_MACHINE_vk-d184280e = "vk-d184280e"
COMPATIBLE_MACHINE_vkrzg2ul = "vkrzg2ul"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "5141064c1552accaf69c6f509bf21b2063b9cff5"

SRC_URI_append_vkrzg2l = " \
	file://0001-add-support-for-cm33-command.patch \
"

SRC_URI += " \
	file://0002-disable-EEE-for-ethernet-LEDs.patch \
	file://0003-resolve-issue-with-multi-mii-buses.patch \
	file://0004-add-option-rawimg-for-fastboot-flash-write-command.patch \
	file://0005-adjust-INFO-for-used-Macronix-flash-devices.patch \
	file://0006-resolve-problem-with-endpoint-maxpacket-while-receiv.patch \
	file://0007-add-support-for-6-vkboards-in-build-system.patch \
	file://0008-add-files-for-6-vkboards.patch \
	file://0009-add-support-for-1GB-board-versions.patch \
	file://0010-add-opencv-accelerator-support-for-vkrzv2l-board.patch \
"
