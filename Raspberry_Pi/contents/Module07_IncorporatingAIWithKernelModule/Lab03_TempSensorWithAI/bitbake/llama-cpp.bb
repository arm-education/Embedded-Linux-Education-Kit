SUMMARY = "llama.cpp - LLM inference engine for local models"
DESCRIPTION = "llama.cpp is a C++ implementation of inference for LLaMA and other models in GGUF format"
HOMEPAGE = "https://github.com/ggml-org/llama.cpp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1539dadbedb60aa18519febfeab70632"


SRCREV = "360d6533db39e11577afe9b0aece20c6b5ddaf1f"
SRC_URI = " \
    git://github.com/ggml-org/llama.cpp.git;branch=master;protocol=https \
"

S = "${WORKDIR}/git"

DEPENDS = "cmake"

inherit cmake

FILES:${PN} += "${bindir}/llama-cli"
FILES:${PN} += " \
    ${libdir}/libggml-base.so \
    ${libdir}/libggml-cpu.so \
    ${libdir}/libggml.so \
    ${libdir}/libmtmd.so \
    ${libdir}/libllama.so \
    ${libdir}/libggml-cpu.so \
"

INSANE_SKIP:${PN} += "buildpaths already-stripped dev-deps"
INSANE_SKIP:${PN}-dev += "dev-elf"


do_install() {
    install -d ${D}${bindir}
    install -d ${D}${libdir}
    
    install -m 0755 ${B}/bin/llama-cli ${D}${bindir}/llama-cli
    install -m 0644 ${B}/bin/libllama.so ${D}${libdir}/libllama.so
    install -m 0644 ${B}/bin/libggml.so ${D}${libdir}/libggml.so
    install -m 0644 ${B}/bin/libggml-base.so ${D}${libdir}/libggml-base.so
    install -m 0644 ${B}/bin/libggml-cpu.so ${D}${libdir}/libggml-cpu.so
    
}