# extend packages

IMAGE_INSTALL_append = " \
        kernel-module-uvcvideo \
        libgpiod \
	devmem2 \
        "
IMAGE_INSTALL_append = " \
        python3-pip \
        python3-smbus \
        python3-spidev \
        python3-pyserial \
        python3-pyusb \
        "

IMAGE_INSTALL_append = " \
        python3-opencv \
        opencv-samples \
        "

IMAGE_INSTALL_append = " \
        python3-evdev \
        evtest \
        "

IMAGE_INSTALL_append = " \
        iw \
        wpa-supplicant \
        bluez5 \
        "

#IMAGE_INSTALL_append = " \
#	docker \
#"

