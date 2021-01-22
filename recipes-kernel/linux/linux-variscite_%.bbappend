SRC_URI += "file://imx8mm-resptech.dts;subdir=git/arch/${ARCH}/boot/dts/freescale"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

KERNEL_DEVICETREE = "imx8mm-resptech.dts"

