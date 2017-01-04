package app.services.workshop;

import app.domain.dto.xmlImport.workshop.WorkshopXmlDto;

public interface WorkshopService {

    void create(WorkshopXmlDto workshopXmlDto);
}