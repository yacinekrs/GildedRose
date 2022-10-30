package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
    assertThat(element.sellIn, is(-1));
  }

  @Test
  @DisplayName("Test quality et sellin avec une biere qui n'existe pas ")
  void testyacine() {
    Item element = new Item("yacine", 7, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(6));
    assertThat(element.quality, is(3));
  }

  @Test
  @DisplayName("Test quality et sellin avec une biere qui n'existe pas avec sellin a 0")
  void testYacsellin() {
    Item element = new Item("yacine", 0, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(-1));
    assertThat(element.quality, is(3));
  }


}
