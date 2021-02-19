FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://defconfig \
            file://0001-Switch-to-custom-device-tree.patch"
KBUILD_DEFCONFIG_imx8mm-var-dart = ""
