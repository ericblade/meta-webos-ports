SUMMARY = "Instant Messaging Account Validator service"
SECTION = "webos/services"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYRIGHT;md5=b928fe818deef43f0b52d28bd42f56f2 \
"

DEPENDS = "glib-2.0 db8 pidgin luna-service2"

PV = "3.0.5+gitr${SRCPV}"
SRCREV = "8a3e587a14dd60f63348ed5d006ef1840e92de13"

inherit webos_ports_repo
inherit webos_cmake
inherit pkgconfig
inherit webos_system_bus
inherit webos_filesystem_paths

SRC_URI = "${WEBOS_PORTS_GIT_REPO_COMPLETE}"
S = "${WORKDIR}/git"

RRECOMMENDS_${PN} += " \
    pidgin-sipe \
    whatsapp-purple \
    purple-skypeweb \
    funyahoo-plusplus \
    libpurple-plugin-autoaccept \
    libpurple-plugin-buddynote \
    libpurple-plugin-idle \
    libpurple-plugin-joinpart \
    libpurple-plugin-log_reader \
    libpurple-plugin-newline \
    libpurple-plugin-offlinemsg \
    libpurple-plugin-psychic \
    libpurple-plugin-ssl \
    libpurple-plugin-ssl-gnutls \
    libpurple-plugin-statenotify \
    libpurple-protocol-aim \
    libpurple-protocol-bonjour \
    libpurple-protocol-gg \
    libpurple-protocol-icq \
    libpurple-protocol-irc \
    libpurple-protocol-mxit \
    libpurple-protocol-myspace \
    libpurple-protocol-novell \
    libpurple-protocol-simple \
    libpurple-protocol-xmpp \
    libpurple-protocol-zephyr \
"

CXXFLAGS += "-fpermissive"
