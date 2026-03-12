DESCRIPTION = "TinyLlama GGUF model file"
LICENSE = "CLOSED"

SRC_URI = "https://huggingface.co/TheBloke/TinyLlama-1.1B-Chat-v1.0-GGUF/resolve/main/tinyllama-1.1b-chat-v1.0.Q6_K.gguf"
SRC_URI[sha256sum] = "9fb2be7c8bbc0ca358ae88cef6d9e6844b81929eaffa5016a543e6f56b22cb6d"

FILES:${PN} = "/opt/llama-models/tinyllama-1.1b-chat-v1.0.Q6_K.gguf"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/opt/llama-models
    install -m 0644 ${S}/tinyllama-1.1b-chat-v1.0.Q6_K.gguf ${D}/opt/llama-models/
}