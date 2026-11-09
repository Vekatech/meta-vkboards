SUMMARY = "Merge machine and distro options for packages for VK CLP"

#
# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

PACKAGES = " \
	packagegroup-vk-clp-tools \
	packagegroup-vk-clp-tools-base \
	packagegroup-vk-clp-tools-utils \
"

RDEPENDS:packagegroup-vk-vlp-tools = " \
	packagegroup-vk-clp-tools-base \
	packagegroup-vk-clp-tools-utils \
"

RDEPENDS:packagegroup-vk-clp-tools-base = " \
	packagegroup-base \
	busybox \
	ckermit \
	dosfstools \
	util-linux \
	ethtool \
	i2c-tools \
	minicom \
	mtd-utils \
	tcf-agent \
	watchdog \
	mmc-utils \
"

RDEPENDS:packagegroup-vk-clp-tools-utils = " \
    libgpiod \
    libgpiod-tools \
    libubootenv \
    libubootenv-bin \
    openssh-sshd \
    openssh-sftp-server \
    openssh-keygen \
    rsync \
    nano \
"