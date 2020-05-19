# Start with OL runtime.
# tag::from[]
FROM openliberty/open-liberty:kernel-java8-openj9-ubi
# end::from[]

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

# Run the server script and start the defaultServer by default.
# tag::entrypoint[]
ENTRYPOINT ["/opt/ol/wlp/bin/server", "run"]
# end::entrypoint[]
# tag::default-start[]
CMD ["defaultServer"]
# end::default-start[]
