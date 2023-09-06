package com.jsfwithspring.controller;

import com.jsfwithspring.domain.Client;
import com.jsfwithspring.service.ClientService;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.primefaces.PrimeFaces;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
@ViewScoped
@Slf4j
public class ClientBean implements Serializable {

    @Getter
    @Setter
    private Client newClient;

    @Getter
    private List<Client> clients;

    @Autowired
    private ClientService clientService;

    public void init() {
        initClientFields();
        searchForClients();
    }

    public void searchForClients() {
        log.info("Searching for clients");
        clients = clientService.findAll();
    }

    private void initClientFields() {
        newClient = new Client();
    }

    public void create() {
        log.info(String.format("Saving client %s", newClient.getName()));
        clientService.create(newClient);
        log.info("Client saved successfully");
        init();
        updateComponents("formPanel", "tablePanel");
    }

    public void prepareUpdate(Client client) {
        log.info(String.format("Preparing client %s for update", newClient.getName()));
        newClient = client;
        updateComponents("formPanel");
    }

    public void delete(Client client) {
        log.info(String.format("Deleting client %s", client.getName()));
        clientService.delete(client);
        log.info("Client deleted successfully");
        searchForClients();
        updateComponents("tablePanel");
    }

    private void updateComponents(String... components) {
        log.info(String.format("Updating components %s",
                Stream.of(components).collect(Collectors.joining(", "))));
        PrimeFaces.current().ajax().update(components);
    }

}
