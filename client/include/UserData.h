#pragma once

using namespace std;

#include "Frame.h"
#include <mutex>
#include <condition_variable>
#include <queue>


class UserData{

    private:
    
        UserData(); // Private constructor

        // singleton
        static UserData* instance;
        bool connected;
        string userName;
        mutex m;
        queue<Frame> actionQueue;
        condition_variable cv;

    public:

        ~UserData() = delete;
        UserData(const UserData&) = delete; // Prevent copy-construction
        UserData& operator=(const UserData&) = delete; // Prevent assignment

        static UserData& getInstance();

        bool isConnected();
        void setConnected(bool connected);

        void setUserName(string userName);
        string getUserName();

        void wait();
        void notifyAll();

        void addAction(Frame frame);
        queue<Frame> getActionQueue();

};
