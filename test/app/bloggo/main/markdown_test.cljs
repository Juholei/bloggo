(ns bloggo.main.markdown-test
  (:require [bloggo.main.markdown :as sut]
            [cljs.test :refer [deftest testing is]]))

(deftest test-markdown->hiccup
  (testing "# Produces h1"
    (is (= (sut/markdown->hiccup "# title")
           [:div {} [:h1 {} "title"]]))))

