DESCRIPTION = "hello driver"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${BPN}.c;endline=44;md5=2c7c6bf3402cde2ac4fbeba9f6497456"

inherit module

PR = "r0"

SRC_URI = "file://Makefile file://${BPN}.c"
S = "${WORKDIR}"
