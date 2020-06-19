# Start with OL runtime.
# tag::from[]
FROM openliberty/open-liberty:kernel-java8-openj9-ubi
# end::from[]

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

LABEL \
  org.opencontainers.image.authors="Your Name" \
  org.opencontainers.image.vendor="IBM" \
  org.opencontainers.image.url="local" \
  org.opencontainers.image.source="https://github.com/OpenLiberty/guide-docker" \
  org.opencontainers.image.version="$VERSION" \
  org.opencontainers.image.revision="$REVISION" \
  vendor="Open Liberty" \
  name="system" \
  version="$VERSION-$REVISION" \
  summary="The system microservice from the Docker Guide" \
  description="This image contains the system microservice running with the Open Liberty runtime."

# tag::user-root[]
USER root
# end::user-root[]
# Symlink servers directory for easier mounts.
# tag::link[]
RUN ln -s /opt/ol/wlp/usr/servers /servers
# end::link[]
# tag::user[]
USER 1001
# end::user[]
