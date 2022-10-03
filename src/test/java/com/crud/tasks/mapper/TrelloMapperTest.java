package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void mapToBoardsTest() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "name test 1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "name test 2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "name test 3", false);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "name test 1", List.of(trelloListDto1, trelloListDto2));
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "name test 2", List.of(trelloListDto3));

        List<TrelloBoardDto> trelloBoardDtoList = List.of(trelloBoardDto1, trelloBoardDto2);

        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(trelloBoardDtoList.size(), trelloBoardList.size());
        assertEquals(trelloBoardDto1.getLists().size(), trelloBoardList.get(0).getLists().size());
    }

    @Test
    void mapToBoardsDtoTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "name test 1", false);
        TrelloList trelloList2 = new TrelloList("2", "name test 2", false);
        TrelloList trelloList3 = new TrelloList("3", "name test 3", false);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "name test 1", List.of(trelloList1, trelloList2));
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "name test 2", List.of(trelloList3));

        List<TrelloBoard> trelloBoardList = List.of(trelloBoard1, trelloBoard2);

        //When
        List<TrelloBoardDto> trelloBoardDtoList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(trelloBoardList.size(), trelloBoardDtoList.size());
        assertEquals(trelloBoard1.getLists().size(), trelloBoardDtoList.get(0).getLists().size());
    }

    @Test
    void mapToListTest() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "name test 1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "name test 2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "name test 3", false);

        List<TrelloListDto> trelloListDtoList = List.of(trelloListDto1, trelloListDto2, trelloListDto3);

        //When
        List<TrelloList> trelloList = trelloMapper.mapToList(trelloListDtoList);

        //Then
        assertEquals(trelloListDtoList.size(), trelloList.size());
        assertEquals(trelloListDto1.getName(), trelloList.get(0).getName());
    }

    @Test
    void mapToListDtoTest() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "name test 1", false);
        TrelloList trelloList2 = new TrelloList("2", "name test 2", false);
        TrelloList trelloList3 = new TrelloList("3", "name test 3", false);

        List<TrelloList> trelloListList = List.of(trelloList1, trelloList2, trelloList3);

        //When
        List<TrelloListDto> trelloDtoList = trelloMapper.mapToListDto(trelloListList);

        //Then
        assertEquals(trelloListList.size(), trelloDtoList.size());
        assertEquals(trelloList1.getName(), trelloDtoList.get(0).getName());
    }

    @Test
    void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name test 1", "description test 1", "pos test 1", "ListId test 1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(trelloCardDto.getName(), trelloCard.getName());
        assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
        assertEquals(trelloCardDto.getPos(), trelloCard.getPos());
        assertEquals(trelloCardDto.getListId(), trelloCard.getListId());
    }

    @Test
    void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard("name test 1", "description test 1", "pos test 1", "ListId test 1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(trelloCard.getName(), trelloCardDto.getName());
        assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
        assertEquals(trelloCard.getListId(), trelloCardDto.getListId());
    }
}