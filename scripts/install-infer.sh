#!/bin/bash

export PATH="$INFER_HOME/bin:$PATH"

mkdir -p ~/.infer

if [ ! -e $INFER_HOME/bin ]; then

    wget https://raw.github.com/ocaml/opam/master/shell/opam_installer.sh -O - | sh -s /usr/local/bin

    cd ~/.infer && wget https://github.com/facebook/infer/releases/download/v0.9.2/infer-linux64-v0.9.2.tar.xz
    tar xf infer-linux64-v0.9.2.tar.xz
    rm infer-linux64-v0.9.2.tar.xz

    ./infer-linux64-v0.9.2/build-infer.sh
fi