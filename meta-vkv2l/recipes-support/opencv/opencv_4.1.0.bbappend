FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "${@'file://0001-feat-python-add-DRP-support-in-Python-bindings.patch' if d.getVar('RZ_FEATURE_OPENCVA') == 'True' else ''}"

