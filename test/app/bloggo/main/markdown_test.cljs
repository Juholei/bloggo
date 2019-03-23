(ns bloggo.main.markdown-test
  (:require [bloggo.main.markdown :as sut]
            [cljs.test :refer [deftest testing is]]))

(deftest test-markdown->hiccup
  (testing "# Produces h1"
    (is (= (sut/markdown->hiccup "# title")
           [:div {} [:h1 {} "title"]])))
  (testing "Two Linebreaks produce p tags"
    (is (= (sut/markdown->hiccup "Paragraph\n\nAnother paragraph")
           [:div {}
            [:p {} "Paragraph"]
            [:p {} "Another paragraph"]]))))

(deftest test-take-elements
  (testing "Taking 1 element from produced hiccup gets the first inner element inside a div"
    (is (= (sut/take-elements 1 (sut/markdown->hiccup "Paragraph\n\nAnother paragraph"))
           [:div {}
            [:p {} "Paragraph"]]))))

