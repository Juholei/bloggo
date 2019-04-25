(ns bloggo.editor.controllers.editor-test
  (:require [bloggo.editor.controllers.editor :as sut]
            [cljs.test :refer [deftest testing is]]
            [tuck.core :as t]))

(deftest test-UpdateCurrentPost
  (testing "New value is set to state under [:new-post] path"
    (is (= (t/process-event (sut/->UpdateCurrentPost "new value") {:new-post "new valu"})
           {:new-post "new value"}))))

