#!/bin/bash

export PATH="$INFER_HOME/bin:$PATH"

mkdir -p ~/.infer

if [ ! -e $INFER_HOME/bin ]; then

    #wget https://github.com/ocaml/opam/releases/download/1.2.2/opam-1.2.2-x86_64-Linux
    #chmod +x opam-1.2.2-x86_64-Linux
    #sudo cp opam-1.2.2-x86_64-Linux /usr/local/bin/opam
    #echo y | opam init --comp=4.02.3

    cd ~/.infer && wget https://github.com/facebook/infer/releases/download/v0.9.2/infer-linux64-v0.9.2.tar.xz
    tar xf infer-linux64-v0.9.2.tar.xz
    rm infer-linux64-v0.9.2.tar.xz

    #./infer-linux64-v0.9.2/build-infer.sh

    ./autogen.sh
    ./configure
    make java
fi