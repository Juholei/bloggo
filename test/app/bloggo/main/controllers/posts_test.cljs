(ns bloggo.main.controllers.posts-test
  (:require [bloggo.main.controllers.posts :as sut]
            [cljs.test :refer [deftest testing is]]
            [tuck.core :as tuck]))

(deftest test-SetPosts
  (testing "Tuck event SetPosts sets the posts in the correct place in the app-state and updates page count"
    (is (= (tuck/process-event (sut/->SetPosts {:posts [{:title "Test post"}] :page-count 2}) {})
           {:posts [{:title "Test post"}]
            :page-count 2}))))

(deftest test-GetPosts
  (testing "GetPosts set in-progress? to true"
    (is (true? (-> (sut/->GetPosts 0)
                   (tuck/process-event {})
                   .-app
                   :in-progress?))))
  (testing "GetPosts request url uses the given page number"
    (is (= (-> (sut/->GetPosts 2)
               (tuck/process-event {})
               .-effects
               first
               :path)
           "/posts/2"))))

(deftest test-ShowPost
  (testing "ShowPost sets given post to current post and"
    (is (= (-> (sut/->ShowPost {:title "This is a post"})
               (tuck/process-event {})
               :current-post)
           {:title "This is a post"}))))
