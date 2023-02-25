# Copyright (c) 2012-2023 LG Electronics, Inc.

SUMMARY = "Palm's Better Native JSON library"
AUTHOR = "Yogish S <yogish.s@lge.com>"
SECTION = "webos/libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "yajl glib-2.0 gperf-native flex-native lemon-native gmp uriparser boost"

inherit webos_public_repo
inherit webos_enhanced_submissions
inherit webos_cmake
inherit pkgconfig

WEBOS_VERSION = "2.15.0-15_038a2f0aa9f74a4db831e39a78754e250aeec651"
PR = "r15"

PACKAGECONFIG ??= ""
PACKAGECONFIG:append:class-native = " tools"

# These are the defaults, but explicitly specify so that readers know they exist
EXTRA_OECMAKE += "-DWITH_DOCS:BOOL=FALSE -DWITH_TESTS:BOOL=FALSE -DNO_LOGGING:BOOL=TRUE"
# Disable #line statements in autogenerated files
EXTRA_OECMAKE += "-DLEMON_WITH_LINE:BOOL=FALSE"
# Don't use CMake detection mechanisms for AR (it fails for class-native)
EXTRA_OECMAKE += "-DCMAKE_AR:FILEPATH=${AR}"

PACKAGECONFIG[tools] = "-DPBNJSON_INSTALL_TOOLS:BOOL=TRUE,-DPBNJSON_INSTALL_TOOLS:BOOL=FALSE"

SRC_URI = "${WEBOSOSE_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"