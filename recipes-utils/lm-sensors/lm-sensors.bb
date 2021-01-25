SUMMARY = "A hardware health monitoring package for Linux"
DESCRIPTION = "Lm-sensors is a hardware health monitoring package for Linux. \
               It allows you to access information from temperature, voltage, \
               and fan speed sensors."
HOMEPAGE = "http://www.lm-sensors.org/"
DEPENDS = "sysfsutils virtual/libiconv \
           bison-native flex-native"
LICENSE = "LGPLv2.1 & GPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LGPL;md5=4fbd65380cdd255951079008b364516c \
                    file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SRC_URI = "git://github.com/lm-sensors/lm-sensors.git;protocol=https"
SRCREV = "31d1f125d8076f1c8c8f3224b31d240e6e6a1763"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'LINUX=${STAGING_KERNEL_DIR} EXLDFLAGS="${LDFLAGS}" \
		MACHINE=${TARGET_ARCH} PREFIX=${prefix} CC="${CC}" \
		AR="${AR}" MANDIR=${mandir}'

do_compile () {
	oe_runmake user PROG_EXTRA=sensors
}

do_install () {
	oe_runmake user_install DESTDIR=${D}
}

PACKAGES =+ "libsensors libsensors-dev libsensors-staticdev libsensors-dbg libsensors-doc"
PACKAGES =+ "lmsensors-sensors lmsensors-sensors-dbg lmsensors-sensors-doc"
PACKAGES =+ "lmsensors-scripts"

FILES_lmsensors-scripts = "${bindir}/*.pl ${bindir}/ddcmon ${sbindir}/fancontrol* ${sbindir}/pwmconfig ${sbindir}/sensors-detect"
RDEPENDS_lmsensors-scripts += "lmsensors-sensors perl bash"
RDEPENDS_lmsensors-apps += "perl-module-strict perl-module-vars perl-module-warnings-register perl-module-warnings"
RDEPENDS_lmsensors-scripts += "perl-module-fcntl perl-module-exporter perl-module-xsloader perl-module-exporter-heavy perl-module-file-basename perl-module-constant"

FILES_lmsensors-sensors = "${bindir}/sensors ${sysconfdir}"
FILES_lmsensors-sensors-dbg += "${bindir}/.debug/sensors"
FILES_lmsensors-sensors-doc = "${mandir}/man1 ${mandir}/man5"
FILES_libsensors = "${libdir}/libsensors.so.*"
FILES_libsensors-dbg += "${libdir}/.debug"
FILES_libsensors-dev = "${libdir}/libsensors.so ${includedir}"
FILES_libsensors-staticdev = "${libdir}/libsensors.a"
FILES_libsensors-doc = "${mandir}/man3"
