# Copyright (c) 2021-2022 LG Electronics, Inc.

SUMMARY = "Image Viewer application"
AUTHOR = "Revanth Kumar <revanth.kumar@lge.com>"
SECTION = "webos/apps"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
    file://oss-pkg-info.yaml;md5=3072ffcf5bdbbc376ed21c9d378d14d5 \
"

PV = "0.0.1-15+git${SRCPV}"
SRCREV = "ca49d724d66ff827acee8eb5e95c380fd3fc1de2"

inherit webos_enactjs_app
inherit webos_public_repo

SRC_URI = "${WEBOSOSE_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

WEBOS_ENACTJS_APP_ID = "com.webos.app.imageviewer"
WEBOS_LOCALIZATION_DATA_PATH = "${S}"
WEBOS_LOCALIZATION_XLIFF_BASENAME = "imageviewer"

# Workaround for network access issue during do_compile task
do_compile[network] = "1"
