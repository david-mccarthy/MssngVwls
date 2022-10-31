package com.mssngvwls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MissingVowelServiceTest {
    public static final Map<Integer, String> TEST_INPUT = Map.of(0, "Missing Vowels");
    private MissingVowelService missingVowelService;

    @BeforeEach
    public void before() {
        this.missingVowelService = new MissingVowelService(TEST_INPUT);
    }

    @Test
    public void itCorrectlyStripsVowelsFromAWord() {
        assertEquals("MssngVwls", missingVowelService.getWord());
    }

    @Test
    public void itMatchesTheExpectedAnswer(){
        assertTrue( missingVowelService.check(0, "Missing vowels"));
    }

    @Test
    public void itMatchesExpectedAnswerRegardlessOfCase(){
        assertTrue(missingVowelService.check(0, "miSSinG Vowels"));
    }

}