FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
	file://0001-Restore-compatibility-with-the-Linux-5.10-LTS-kernel.patch \
	file://0001-fix-update-fdtable.h-for-compatibility-with-kernel-v.patch \
"
