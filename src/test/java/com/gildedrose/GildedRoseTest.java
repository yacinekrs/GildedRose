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

  /************************************ Aged Brie ***********************************/
  @Test
  @DisplayName("Test quality et sellin avec aged Brie et le sellin sup a 0")
  void testAgedBsellsup0() {
    Item element = new Item("Aged Brie", 7, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(6));
    assertThat(element.quality, is(6));
  }

  @Test
  @DisplayName("Test quality et sellin avec aged Brie et le sellin devient inf a 0")
  void testAgedBsellinf0() {
    Item element = new Item("Aged Brie", 0, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(-1));
    assertThat(element.quality, is(7));

  }

  /************************************ Backstage ***********************************/
  @Test
  @DisplayName("Test quality et sellin avec Backstage et sellin a 5")
  void testBackSsellinf11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(4));
    assertThat(element.quality, is(7));
  }

  @Test
  @DisplayName("Test quality et sellin avec Backstage et sellin devient inf a 0")
  void testBack0() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
    assertThat(element.sellIn, is(-1));
  }

  @Test
  @DisplayName("Test quality et sellin avec Backstage et sellin sup a 10") 
  void testBacksup10() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 20, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
    assertThat(element.sellIn, is(19));
  }

  @Test
  @DisplayName("Test quality et sellin avec Backstage et sellin devient inf a 3 et quality depasse pas 50") 
  void testBackSsellinf3() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
    assertThat(element.sellIn, is(2));
  }
  /************************************ Sulfuras ***********************************/
  @Test
  @DisplayName("Sulfuras") 
  void testSulf() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 12, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(5));
    assertThat(element.sellIn, is(12));
  }

}
