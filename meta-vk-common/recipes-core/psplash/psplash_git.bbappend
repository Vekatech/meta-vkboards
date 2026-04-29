# 1) Add our local “files/” directory to the search path
FILESEXTRAPATHS_prepend_vk-d184280e := "${THISDIR}/files:"

#2) Replace the stock header with our own ro one
SPLASH_IMAGES_vk-d184280e = "file://psplash-ro.png;outsuffix=default"

#3) Change the progress bar
SRC_URI_append_vk-d184280e = " file://0001-green-progress-bar.patch"
