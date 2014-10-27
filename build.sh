#!/bin/bash

set -eu

application_home=$(pushd $(dirname $0) >/dev/null && pwd -P && popd >/dev/null)
mvn clean package -U -DskipTests
cp $application_home/target/*-jar-with-dependencies.jar $application_home/lib/

exit 0