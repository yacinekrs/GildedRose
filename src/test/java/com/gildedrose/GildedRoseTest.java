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
  @DisplayName("Test quality et sellin avec aged Brie et le sellin sup a 0")/* */
  void testAgedBqualsup50() {
    Item element = new Item("Aged Brie", 7, 51);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(6));
    assertThat(element.quality, is(51));
  }

  @Test
  @DisplayName("Test quality et sellin avec aged Brie et le sellin sup a 0")/* */
  void testAgedBsellinf0qualsup50() {
    Item element = new Item("Aged Brie", 0, 51);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(-1));
    assertThat(element.quality, is(51));
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

  @Test
  @DisplayName("Sulfuras") 
  void testSulfinf0() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -3, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(5));
    assertThat(element.sellIn, is(-3));
  }

  /************************************ ToString ***********************************/
  
  @Test 
  @DisplayName("Afficher les caractéristiques du produit")
  void testToString() {
    Item element = new Item("blueMoon", 0, 0);
    assertThat(element.toString(), is("blueMoon, 0, 0"));
    // element.name, is(());
    // assertThat(element.sellIn, is(0));
    // assertThat(element.quality, is(0));
  }
  /************************************ MUTATION ***********************************/

  @Test
  void testufltd() {
    Item element = new Item("yacine", 3, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
    assertThat(element.sellIn, is(2));
  }

  @Test
  void testmutagedbrie() {
    Item element = new Item("Aged Brie", 3, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
    assertThat(element.sellIn, is(2));
  }

  @Test
  void testmutationbackstageseelin11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(11));
    assertThat(element.sellIn, is(10));
  }

  @Test
    void testBackStagemutationsellin6() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(6));
    assertThat(element.sellIn, is(5));
  }

  @Test
    void testBackStagemutationsellin0() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(7));
    assertThat(element.sellIn, is(0));
  }

  @Test
    void testmutationsulfqlt0() {
    Item element = new Item("yac", 0, 1);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
    assertThat(element.sellIn, is(-1));
  }

  @Test
    void testmutationqltAgdB() {
    Item element = new Item("Aged Brie", 0, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
    assertThat(element.sellIn, is(-1));
  }

  /************************CONJURED************************/

  // @Test
  // @DisplayName("Conjured")
  // void testconjuredsup() {
  //   Item element = new Item("Conjured", 1, 6);
  //   GildedRose app = new GildedRose(new Item[] {element});
  //   app.updateQuality();
  //   assertThat(element.quality, is(4));
  //   // assertThat(element.sellIn, is(-1));
  // }







}
