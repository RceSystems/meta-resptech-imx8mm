FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://defconfig \
            file://0001-Switch-to-custom-device-tree.patch \
            file://0002-FRam-MB85RS4MT.patch \
            file://0003-Clear-I2c-OpenDrain-Warning.patch"
KBUILD_DEFCONFIG_imx8mm-var-dart = ""
