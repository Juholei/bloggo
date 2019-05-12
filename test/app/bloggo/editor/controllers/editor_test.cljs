(ns bloggo.editor.controllers.editor-test
  (:require [bloggo.editor.controllers.editor :as sut]
            [cljs.test :refer [deftest testing is]]
            [tuck.core :as t]))

(deftest test-UpdateNewPostContent
  (testing "New value is set to state under [:new-post] path"
    (is (= (t/process-event (sut/->UpdateNewPostContent "new value") {:new-post {:content "new valu"}})
           {:new-post {:content "new value"}}))))

