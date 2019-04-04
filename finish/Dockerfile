# tag::from[]
# Start with OL runtime.
FROM open-liberty
# end::from[]

USER root
# tag::link[]
# Symlink servers directory for easier mounts.
RUN ln -s /opt/ol/wlp/usr/servers /servers
# end::link[]
USER 1001

# tag::default-start[]
# Run the server script and start the defaultServer by default.
ENTRYPOINT ["/opt/ol/wlp/bin/server", "run"]
CMD ["defaultServer"]
# end::default-start[]
