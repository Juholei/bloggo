(ns bloggo.main.view-resolver-test
  (:require [bloggo.main.view-resolver :as sut]
            [bloggo.main.routes :as routes]
            [cljs.test :refer [deftest testing is]]
            [bloggo.main.views.main-page :refer [main-page]]
            [bloggo.main.views.post-page :refer [post-page]]
            [bloggo.editor.views.editor :refer [editor-page]]
            [bloggo.editor.core]))

  (deftest test-root-view-multimethod
    (testing "View being frontpage gives main-page-component"
      (is (= (first (sut/root-view {:view ::routes/frontpage}))
             main-page)))
    (testing "View being post gives post-page component"
      (is (= (first (sut/root-view {:view ::routes/post}))
             post-page)))
    (testing "View being editor gives editor component from other module"
      (is (= (first (sut/root-view {:view ::routes/editor}))
             editor-page)))
    (testing "View being something that does not exist returns nil"
      (is (nil? (sut/root-view {:view :nonexistent})))))
