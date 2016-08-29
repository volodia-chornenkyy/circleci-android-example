#!/bin/bash

export PATH="$INFER_HOME/bin:$PATH"

mkdir -p ~/.infer

if [ ! -e $INFER_HOME/bin ]; then
    cd ~/.infer && wget https://github.com/facebook/infer/releases/download/v0.9.2/infer-linux64-v0.9.2.tar.xz
    tar xf infer-linux64-v0.9.2.tar.xz
    rm infer-linux64-v0.9.2.tar.xz
    .~/.infer/build-infer.sh
fi