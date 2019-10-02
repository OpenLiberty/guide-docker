# tag::from[]
# Start with OL runtime.
FROM open-liberty
# end::from[]

# tag::user-root[]
USER root
# end::user-root[]
# tag::link[]
# Symlink servers directory for easier mounts.
RUN ln -s /opt/ol/wlp/usr/servers /servers
# end::link[]
# tag::user[]
USER 1001
# end::user[]

# tag::default-start[]
# Run the server script and start the defaultServer by default.
# tag::entrypoint[]
ENTRYPOINT ["/opt/ol/wlp/bin/server", "run"]
# end::entrypoint[]
CMD ["defaultServer"]
# end::default-start[]
